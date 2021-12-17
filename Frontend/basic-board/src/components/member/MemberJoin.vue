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
      Join
    </p>
    <br /><br />
    <b-col sm="10" style="margin: 0 auto">
      <b-form-input id="input-large" size="lg" placeholder="ID"></b-form-input>
      <b-form-input id="input-large" size="lg" placeholder="NAME"></b-form-input>
      <b-form-input id="input-large" size="lg" placeholder="PW"></b-form-input>
      <b-form-input id="input-large" size="lg" placeholder="E-MAIL"></b-form-input>
    </b-col>
    <b-button @click="confirm">회원가입</b-button><br />
    <router-link :to="{ name: 'Home' }">되돌아가기</router-link>
  </div>
</template>

<script>
export default {
  methods: {
    confirm() {
      this.$router.push({ name: "Notice" });
    },
  },
};
</script>

<style></style>
