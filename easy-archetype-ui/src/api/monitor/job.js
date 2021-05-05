import request from '@/utils/request'

let prefix = '/uaa/job'

// 查询定时任务调度列表
export function listJob(query) {
  return request({
    url: prefix + '/list',
    method: 'post',
    data: query
  })
}

// 查询定时任务调度详细
export function getJob(jobId) {
  return request({
    url: prefix + '/' + jobId,
    method: 'get'
  })
}

// 新增定时任务调度
export function addJob(data) {
  return request({
    url: prefix + '',
    method: 'post',
    data: data
  })
}

// 修改定时任务调度
export function updateJob(data) {
  return request({
    url: prefix + '',
    method: 'put',
    data: data
  })
}

// 删除定时任务调度
export function delJob(jobId) {
  return request({
    url: prefix + '/' + jobId,
    method: 'delete'
  })
}

// 导出定时任务调度
export function exportJob(query) {
  return request({
    url: prefix + '/export',
    method: 'get',
    params: query
  })
}

// 任务状态修改
export function changeJobStatus(jobId, status) {
  const data = {
    jobId,
    status
  }
  return request({
    url: prefix + '/changeStatus',
    method: 'put',
    data: data
  })
}

// 定时任务立即执行一次
export function runJob(jobId, jobGroup) {
  const data = {
    jobId,
    jobGroup
  }
  return request({
    url: prefix + '/run',
    method: 'put',
    data: data
  })
}
