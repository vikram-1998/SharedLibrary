def call(String buildStatus = 'STARTED', String slackCredId = '594d2434-df4f-4961-b6ab-05a902316091') {
    buildStatus = buildStatus ?: 'SUCCESS'
    def colorCode = (buildStatus == 'SUCCESS') ? '#00FF00' : (buildStatus == 'STARTED') ? '#FFFF00' : '#FF0000'
    def summary = "${buildStatus}: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})"

    slackSend(
        tokenCredentialId: '594d2434-df4f-4961-b6ab-05a902316091',  // Jenkins credential ID
        channel: '#builds',
        color: colorCode,
        message: summary
    )
}
