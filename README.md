# Jenkins Kata

### Requirements
- Install [Docker](https://docs.docker.com/engine/installation/#supported-platforms).

##### Run Jenkins
```
$ docker run \
	-p 8080:8080 \
	-p 50000:50000 \
	-v jenkins_home:/var/jenkins_home \
	jenkins/jenkins:lts
```

##### Install Jenkins Plugins
- Recommended plugins.
- Blue Ocean.
- Pipeline: AWS Steps.
- Slack Notification Plugin.

##### Slack channel for notifications
- **#kata_jenkins**

##### AWS S3 bucket for uploads
- **kata_jenkins/my-team-name**

## Kata steps:
1. Create a pipeline job. You can use the Scripted or Declarative Pipeline.
2. Create a new step inside the pipeline and download the source code from this repository.
3. Create a new step and build the project. You can use the following command:
    ```
    $ mvn clean package
    ```
   You need to install **Maven 3.5.0** or newer on **Global Tools Configuration**.
4. Upload the JAR artifact to S3. 
   You will need to create a new **User with Password Credentials** to store your AWS public and private keys.
   The **Pipeline: AWS Steps Plugin** can be your friend here.
5. Send Slack notification on **#kata_jenkins** channel using the **Slack Notification Plugin**.
   You can send any information like job name, build number etc...
6. Send Slack notification in case of error. You can add the exception to the message body.
7. Pipeline as code. Move the pipeline code in a new Jenkinsfile and push it to the same repository.
   Pool the repository to detect any commit changes and start the build.