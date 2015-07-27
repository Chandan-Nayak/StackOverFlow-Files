import jenkins
import time

qa_job = 'python-jenkins-test'


j = jenkins.Jenkins('http://localhost:8080')

if j.job_exists(qa_job):
    job_info = j.get_job_info(qa_job)
    success_build_number_before = job_info['lastCompletedBuild']['number']
    print('last_success_build_number Before Build:', success_build_number_before)

    print('Start job')
    j.build_job(qa_job)
    job_info = j.get_job_info(qa_job)

    while j.get_queue_info():
        print('waiting for queue to be over!')
        time.sleep(1)

    print('Queue over!!')
    time.sleep(1)

    while "".join([d['color'] for d in j.get_jobs() if d['name'] == qa_job]) == 'blue_anime':
        print('Job is Running')
        time.sleep(1)

    print('Job Over!!')

    job_info = j.get_job_info(qa_job)
    success_build_number_after = job_info['lastCompletedBuild']['number']
    print('last_success_build_number Before After:', success_build_number_after)

else:
    print('no job named {0} over there!!'.format(qa_job))
