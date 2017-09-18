FROM ubuntu:latest

# Install Dependencies

RUN apt-get update && \
    apt-get install -y \
    default-jdk \
    git \
    ant \
    && \
    apt-get clean 

RUN groupadd -r ant-dev && useradd -r -g ant-dev ant-dev

# Setup Environment Variables

ENV WORK_DIR="/ant-dev"

# Make dir
RUN mkdir -p ${WORK_DIR} && chown ant-dev:ant-dev ${WORK_DIR}

# Clone & Check Out

RUN sudo --user=ant-dev git clone https://github.com/masters3d/AntSieve.git && \
    cd ${WORK_DIR} && \
    sudo --user=ant-dev git fetch && \
    sudo --user=ant-dev git checkout master
    
# Entrypoint
ADD entrypoint /
ENTRYPOINT ["/entrypoint"]