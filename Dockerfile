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

# Setup Users
RUN groupadd -r ant-dev && useradd -r -g ant-dev ant-dev

# Setup SSH server options
RUN mkdir /var/run/sshd
RUN echo "AllowGroups ant-dev" >> /etc/ssh/sshd_config
RUN echo 'ant-dev:devPassword' | chpasswd

# SSH login fix. Otherwise user is kicked off after login
RUN sed 's@session\s*required\s*pam_loginuid.so@session optional pam_loginuid.so@g' -i /etc/pam.d/sshd

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