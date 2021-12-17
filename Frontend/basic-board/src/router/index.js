import Vue from "vue";
import VueRouter from "vue-router";

import Home from "../views/Home.vue";
import MemberLogin from "@/components/member/MemberLogin.vue";
import MemberJoin from "@/components/member/MemberJoin.vue";

import Notice from "@/components/notice/notice.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "login",
    name: "MemberLogin",
    component: MemberLogin,
  },
  {
    path: "memberjoin",
    name: "MemberJoin",
    component: MemberJoin,
  },
  {
    path: "/notice",
    name: "Notice",
    component: Notice,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
