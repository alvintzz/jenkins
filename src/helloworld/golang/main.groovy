#!/usr/bin/groovy
package helloworld

def main(){
    
    env.REPOSITORY_NAME = "testapp"
    env.BRANCH_NAME = "main"
    env.REPOSITORY_DIR = "/go/src/github.com/alvintzz/$REPOSITORY_NAME"

    ansiColor('xterm') {
        stage('Pull Code from Github') {
            dir("$REPOSITORY_DIR") {
                git branch: "$BRANCH_NAME", url: "https://github.com/tokopedia/${REPOSITORY_NAME}.git"
            }
        }

        stage('Just Print something') {
            steps {
                echo 'Just Print something here.'
            }
        }
    }
}

return this
