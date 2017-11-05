# Jenkins Kata

## Requirements
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
2. Create a new step inside the pipeline and download the source code from this repository (master branch).
3. Create a new step and build the project. You can use the following command:
    ```
    $ mvn clean package
    ```
   You need to install **Maven 3.5.0** or newer on **Global Tools Configuration**.
4. Publish on Jenkins your test results using the **junit** step.
   Capture the JAR builded from the **/target** directory and save it to Jenkins for later retrieval. You can use the **archive** step. 
5. Upload the JAR artifact to AWS S3. 
   You need to create a new **User with Password Credentials** to store your AWS public and private keys.
   The **Pipeline: AWS Steps Plugin** can be your friend here.<br />
   Hint: you need AWS credentials for this step.
6. Send Slack notification on **#kata_jenkins** channel using the **Slack Notification Plugin**.
   You can send any information like job name, build number etc...<br />
   Hint: you need the Slack URL and token for this step.
7. Send Slack notification in case of error. You can add the exception to the message body.
8. Pipeline as code. Move the pipeline code in a Jenkinsfile and push it to the same repository.
   Pool the repository to detect any commit changes and start the build withouth manual steps.
   Hint: you need to fork this repository or mount the $HOME folder as volume to the Jenkins container with '-v' option.
   
## Utils
##### Jenkins Documentation
https://jenkins.io/doc/

##### Jenkins Pipeline
https://jenkins.io/doc/book/pipeline/

##### Jenkinsfile
https://jenkins.io/doc/book/pipeline/jenkinsfile/

##### Jenkins Plugins
https://jenkins.io/doc/book/managing/plugins/

##### Jenkins Blue Ocean
https://jenkins.io/doc/book/blueocean/

##### Pipeline: AWS Steps
https://github.com/jenkinsci/pipeline-aws-plugin

##### Slack Notification Plugin
https://github.com/jenkinsci/slack-plugin
