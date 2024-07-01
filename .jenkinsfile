pipeline

{

agent any
stages
{

stage('BuildAndPublish')
{
steps
{
bat "mvn clean"
}
}

stage('deploy')
{
steps{
echo 'deploying the code'
}
}

stage('SmokeTesting')
{
steps
{
bat "mvn compile"
}
}

stage('Release')
{
steps
{
echo 'releasing the project'
}
}
}
}