import { apiInstance } from "./index.js";

const api = apiInstance();

// 찜목록 등록
async function writeWish(wish, success, fail) {
  await api.post(`/wishlist`, JSON.stringify(wish)).then(success).catch(fail);
}
// 찜목록 삭제
function deleteWish(wish, success, fail) {
  api.post(`/wishlist/remove`, JSON.stringify(wish)).then(success).catch(fail);
}
// 회원정보 찜목록
function getWish(userid, success, fail) {
  api.get(`/wishlist/${userid}`).then(success).catch(fail);
}
// 찜여부 확인
async function checkWish(wish, success, fail) {
  await api
    .post(`/wishlist/check`, JSON.stringify(wish))
    .then(success)
    .catch(fail);
}
// 회원의 찜목록 개수
function countWish(userid, success, fail) {
  api.get(`/wishlist/count/${userid}`).then(success).catch(fail);
}
export { writeWish, deleteWish, getWish, checkWish, countWish };
