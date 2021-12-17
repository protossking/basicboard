<template>
  <div class="container">
    <p
      style="
        font-family: 'Koreageulggol';
        font-size: 150pt;
        text-decoration-line: none;
        color: red;
      "
    >
      Login
    </p>
    <br /><br />
    <b-col sm="10" style="margin: 0 auto">
      <b-form-input
        id="loginId"
        size="lg"
        v-model="loginId"
        placeholder="ID"
      ></b-form-input
      ><br />
      <b-form-input
        id="loginPassword"
        size="lg"
        v-model="loginPassword"
        placeholder="PW"
      ></b-form-input
      ><br />
    </b-col>
    <b-button @click="confirm"
      ><img
        src="https://img.icons8.com/fluency/55/000000/gift--v2.png" /></b-button
    ><br />
    <router-link :to="{ name: 'MemberJoin' }">회원가입</router-link>
  </div>
</template>

<script>
import { login } from "@/api/member.js";
export default {
  name: "MemberLogin",
  data() {
    return {
      loginId: null,
      loginPassword: null,
    };
  },
  methods: {
    confirm() {
      console.log(this.loginId, this.loginPassword);
      var data = {
        loginId: this.loginId,
        loginPassword: this.loginPassword,
      };
      login(
        data,
        (response) => {
          console.log(response.data);
          const session = sessionStorage.getItem("JSESSIONID", data);
          console.log(session);
          this.$router.push({ name: "Notice" });
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style>
body {
  background-image: url("../../assets/img/loginimg.jpg");
  height: 100vh; /*각 화면에 맞는 꽉 찬 사이즈로 변경*/
  background-repeat: no-repeat;
  background-size: cover;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
