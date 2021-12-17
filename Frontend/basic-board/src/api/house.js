import { apiInstance, houseInstance } from "./index.js";

const api = apiInstance();
const house = houseInstance();

function sidoList(success, fail) {
  api.get(`/house/sido`).then(success).catch(fail);
}

function gugunList(params, success, fail) {
  api.get(`/house/gugun`, { params: params }).then(success).catch(fail);
}

function dongList(params, success, fail) {
  api.get(`/house/dong`, { params: params }).then(success).catch(fail);
}

function houseList(params, success, fail) {
  house.get(`/house/apt`, { params: params }).then(success).catch(fail);
}

function getHouseRecommend(userid, success, fail) {
  house.get(`/house/recommend/${userid}`).then(success).catch(fail);
}

export { sidoList, gugunList, houseList, dongList, getHouseRecommend };
