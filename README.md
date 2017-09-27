## Ant Sieve

## Password for the user
Please change the default password in the `dockerfile` before building.
`ant-dev:devPassword`

### How to build
`docker build -t ant-dev .`

### This is how you run the container on the background
`docker run -d -P --name ant-dev ant-dev`

The P here is needed to expose the ports
If you only want to run on the foreground:  
`docker run -P -it ant-dev bash`

### Once it is running you can connect with
You need to get the host mapping of the 22 port.
`ssh ant-dev@0.0.0.0 -p 32773`

### To stop you can use this command:
`docker stop ant-dev`

### To restart
`docker restart ant-dev`
This will restart the container with the same options that when it was created. For example: expose ports will be visible.

### References

[Run Docker Image](https://stackoverflow.com/questions/18497688/run-a-docker-image-as-a-container)
[Fix git configure permission](https://confluence.atlassian.com/stashkb/permission-denied-on-git-config-file-314447088.html)
[Add an SSH port](https://docs.docker.com/engine/examples/running_ssh_service/#build-an-eg_sshd-image)
