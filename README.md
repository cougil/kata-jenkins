# Jenkins Kata

#### Requirements
- Install [Docker](https://docs.docker.com/engine/installation/#supported-platforms).

#### Run Jenkins
```
$ docker run \
	-p 8080:8080 \
	-p 50000:50000 \
	-v jenkins_home:/var/jenkins_home \
	jenkins/jenkins:lts
```

#### Install Jenkins Plugins
- Blue Ocean
- Pipeline: AWS Steps
- Slack Notification Plugin

#### Slack channel for notifications
- **#kata_jenkins**

#### AWS S3 bucket for uploads
- **kata_jenkins/my-team-name**