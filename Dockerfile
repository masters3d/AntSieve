FROM ubuntu:latest

# Install Dependencies

RUN apt-get update && \
    apt-get install -y \
    autoconf \
    ant \
    default-jdk \
    git \
    sudo \
    openssh-server \
    && \
    apt-get clean 

RUN groupadd -r ant-dev && useradd -r -g ant-dev ant-dev

# Setup Environment Variables

ENV WORK_DIR="/ant-dev"

# Make dir and add permissions 
RUN mkdir -p ${WORK_DIR} && \
	chown ant-dev:ant-dev ${WORK_DIR} && \
	chown ant-dev.ant-dev -R /root/

# Clone & Check Out

RUN cd ${WORK_DIR} && \
	sudo --user=ant-dev git clone https://github.com/masters3d/AntSieve.git && \
	cd AntSieve && \
    sudo --user=ant-dev git fetch 
    
ENV NOTVISIBLE "in users profile"
RUN echo "export VISIBLE=now" >> /etc/profile

EXPOSE 22
CMD ["/usr/sbin/sshd", "-D"]