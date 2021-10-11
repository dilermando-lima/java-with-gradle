# Simple project with gradle

This project show us a simple project with gradle, log4j2, jacoco and sonar  

  * [1 Install jdk11](#1-install-jdk11)
    + [1.1 download jdk11](#11-download-jdk11)
    + [1.2 setting JAVA_HOME var](#12-setting-java-home-var)
  * [2 Install gradle](#2-install-gradle)
    + [2.1 download gradle](#21-download-gradle)
    + [2.3 set GRADLE_HOME VAR](#23-set-gradle-home-var)
  * [3 Create gradle wrapper](#3-create-gradle-wrapper)
  * [4 Some helpful commands](#4-some-helpful-commands)
  * [5 Custom tasks](#5-custom-tasks)
  * [6 Using Sonar on source](#6-using-sonar-on-source)
  * [7 Building and running application](#7-building-and-running-application)

## 1 Install jdk11
### 1.1 download jdk11
Download jdjk11 from oracle https://www.oracle.com/java/technologies/downloads/#java11 ( suggested jdk-11.0.12_linux-x64_bin.deb for ubuntu 64 ). after installed try `java -version` to confirm installation.

### 1.2 setting JAVA_HOME var
Creating file to be read from profile
```bash
sudo nano /etc/profile.d/jdk.sh
```
Add informantion bellow into jdk.sh file
```bash

sudo nano /etc/profile.d/jdk.sh

# add this vars into  /etc/profile.d/jdk.sh
#   export JAVA_HOME=/usr/lib/jvm/jdk-11.VERSION_FROM_JDK_DOWNLOADED
#   export PATH=$PATH:$JAVA_HOME/bin

# use `whereis java ` to check java folder

sudo chmod +x /etc/profile.d/jdk.sh
source /etc/profile.d/jdk.sh
```


## 2 Install gradle
Install gradle with specific version. After installed try `gradle -v` to confirm installation:

### 2.1 download gradle

```bash
VERSION=6.9.1
wget https://services.gradle.org/distributions/gradle-${VERSION}-bin.zip -P /tmp
sudo unzip -d /opt/gradle /tmp/gradle-${VERSION}-bin.zip
sudo ln -s /opt/gradle/gradle-${VERSION} /opt/gradle/latest
```

Check all available releases https://gradle.org/releases/

### 2.3 set GRADLE_HOME VAR
```bash
sudo nano /etc/profile.d/gradle.sh

# add this vars into  /etc/profile.d/gradle.sh
#   export GRADLE_HOME=/opt/gradle/latest
#   export PATH=${GRADLE_HOME}/bin:${PATH}

sudo chmod +x /etc/profile.d/gradle.sh
source /etc/profile.d/gradle.sh
```


## 3 Create gradle wrapper

You can create a wrapper to add in each project 

```
gradle wrapper
```

So in each project you can use a wrapper gradle

```
./gradlew -v
./gradlew build
```

## 4 Some helpful commands
Command                   |  Description              | Comments
---                       |  ---                      | ---
`./gradlew clean`         |  Clean all builds         |
`./gradlew clean build`   |  Clean and build project  |
`./gradlew build -x test` |  Build skping task 'test' | `-x` is `--exclude-task` 
`./gradlew build --refresh-dependencies` | Build refreshing hardly |
`./gradlew build --build-file build2.gradle` | Build using different build file |
`./gradlew run`           |  Run app with gradle | Required `plugins { id "application" }`


## 5 Custom tasks
There are some aditional tasks in `./custom-task.gradle` file


Run sonar docker container
  - `./gradlew --build-file custom-task.gradle -q sonar-up`
  - `./gradlew --build-file custom-task.gradle -q sonar-down`

## 6 Using Sonar on source
All sonar settings are in `gradle.properties` and implemented in `build.gradle`.

Check some available commands

Command                     |  Description              | Comments
---                         |  ---                      | ---
`./gradlew clean`           |  Clean all builds         |
`./gradlew jacocoTestReport`|  Generate All report of test coveraging  | will be availabled in `./build/reports/jacoco/test/html/index.html`
`./gradle --build-file custom-task.gradle -q sonar-up`  |  Start Sonar container | 
`./gradlew sonarqube`        | Run sonarqube process    |              


## 7 Building and running application

Building application
```
./gradlew build
```

Run built application
```
java -jar -Dlogging.level=INFO -Dlogging.package=com.test ./build/libs/teste-*.jar
# OR
java -jar -Dlogging.level=DEBUG -Dlogging.package=root ./build/libs/teste-1.0.0.jar
# OR
java -jar ./build/libs/teste-*.jar
```











