import { apiInstance } from "./index.js";

const api = apiInstance();

async function login(user, success, fail) {
  await api.post(`/login`, JSON.stringify(user)).then(success).catch(fail);
}

async function logout(user, success, fail) {
  await api.post(`/logout`, JSON.stringify(user)).then(success).catch(fail);
}


export { login, logout };
