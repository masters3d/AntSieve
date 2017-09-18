## Ant Sieve

## How to build

`docker build -t ant-dev .`
### The P here is needed to expose the ports
`docker run -P ant-dev`

### This is how you get into the container
`docker run -it ant-dev bash`

### This is how you run the container
`docker run -d -P --name ant-dev ant-dev`
## Once it is running you can connect with
You need to get the host mapping of the 22 port.
`ssh ant-dev@localhost -p 32773`

### References

[Run Docker Image](https://stackoverflow.com/questions/18497688/run-a-docker-image-as-a-container)
[Fix git configure permission](https://confluence.atlassian.com/stashkb/permission-denied-on-git-config-file-314447088.html)
[Add an SSH port](https://docs.docker.com/engine/examples/running_ssh_service/#build-an-eg_sshd-image)
