import { apiInstance } from "./index.js";

const api = apiInstance();

// 질문전체조회
function listQuestion(param, success, fail) {
  api.get(`/qna/question`, { params: param }).then(success).catch(fail);
}
// 질문등록
function writeQuestion(question, success, fail) {
  api.post(`/qna/question`, JSON.stringify(question)).then(success).catch(fail);
}
// 질문수정
function modifyQuestion(question, success, fail) {
  api.put(`/qna/question`, JSON.stringify(question)).then(success).catch(fail);
}
// 질문조회
function getQuestion(num, success, fail) {
  api.get(`/qna/question/${num}`).then(success).catch(fail);
}
// 질문삭제
function deleteQuestion(num, success, fail) {
  api.delete(`/qna/question/${num}`).then(success).catch(fail);
}
//--------------
// 답변전체조회
function listAnswer(num, success, fail) {
  api.get(`/qna/answer/list/${num}`).then(success).catch(fail);
}
// 답변등록
function writeAnswer(answer, success, fail) {
  api.post(`/qna/answer`, JSON.stringify(answer)).then(success).catch(fail);
}
// 답변수정
function modifyAnswer(answer, success, fail) {
  api.put(`/qna/answer`, JSON.stringify(answer)).then(success).catch(fail);
}
// 답변조회
function getAnswer(num, success, fail) {
  api.get(`/qna/answer/${num}`).then(success).catch(fail);
}
// 답변삭제
function deleteAnswer(num, success, fail) {
  api.delete(`/qna/answer/${num}`).then(success).catch(fail);
}

export {
  listQuestion,
  writeQuestion,
  modifyQuestion,
  getQuestion,
  deleteQuestion,
  writeAnswer,
  modifyAnswer,
  getAnswer,
  deleteAnswer,
  listAnswer,
};
