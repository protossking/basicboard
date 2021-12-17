<template>
  <div>
    <b-navbar toggleable="lg" fixed="top">
      <div>
        <router-link
          :to="{ name: 'Notice' }"
          style="
            font-family: 'twayair';
            font-size: 30pt;
            text-decoration-line: none;
            color: white;
          "
          >Home</router-link
        >
      </div>
      <div style="margin: 0 auto">
        <router-link
          :to="{ name: 'Notice' }"
          style="
            font-family: 'twayair';
            font-size: 17pt;
            text-decoration-line: none;
            color: white;
          "
          >게시판</router-link
        >
        &nbsp;
        <router-link
          :to="{ name: '#' }"
          style="
            font-family: 'twayair';
            font-size: 17pt;
            text-decoration-line: none;
            color: white;
          "
          >구경하기</router-link
        >
      </div>
      <router-link
        :to="{ name: 'MemberLogin' }"
        style="
          font-family: 'twayair';
          font-size: 17pt;
          text-decoration-line: none;
          color: white;
        "
        >로그인</router-link
      >
      &nbsp;
      <router-link
        :to="{ name: 'MemberJoin' }"
        style="
          font-family: 'twayair';
          font-size: 17pt;
          text-decoration-line: none;
          color: white;
        "
        >회원가입</router-link
      >
      &nbsp;&nbsp;
    </b-navbar>
  </div>
</template>

<script>
import "@/assets/css/font.css";

export default {
  name: "NaviBar",
  computed: {},
  methods: {},
};
</script>

<style>
.navbar {
}
</style>
