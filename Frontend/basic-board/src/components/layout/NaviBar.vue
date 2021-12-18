<template>
  <div>
    <b-navbar fixed="top">
      <div>
        &nbsp;&nbsp;
        <router-link
          :to="{ name: 'Home' }"
          style="
            font-family: 'Koreageulggol';
            font-size: 30pt;
            text-decoration-line: none;
            color: black;
          "
          >Home</router-link
        >
      </div>
      <div style="margin: 0 auto">
        <router-link
          :to="{ name: 'Notice' }"
          style="
            font-family: 'Koreageulggol';
            font-size: 25pt;
            text-decoration-line: none;
            color: black;
          "
          >게시판</router-link
        >
        &nbsp;
        <router-link
          :to="{ name: '#' }"
          style="
            font-family: 'Koreageulggol';
            font-size: 25pt;
            text-decoration-line: none;
            color: black;
          "
          >구경하기</router-link
        >
      </div>
      <router-link
        :to="{ name: 'MemberLogin' }"
        style="
          font-family: 'Koreageulggol';
          font-size: 25pt;
          text-decoration-line: none;
          color: blue;
        "
        >로그인</router-link
      >
      &nbsp;&nbsp;
      <router-link
        :to="{ name: 'MemberJoin' }"
        style="
          font-family: 'Koreageulggol';
          font-size: 25pt;
          text-decoration-line: none;
          color: blue;
        "
        >회원가입</router-link
      >
      &nbsp;&nbsp;&nbsp;
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
