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
    <!-- 아이디 -->
    <b-col sm="20" style="margin: 0 auto">
      <b-input-group-prepend
        is-text
        style="font-family: 'KyoboHand'; text-decoration-line: none"
      >
        <b-icon icon="person-fill"></b-icon> &nbsp;아이디
      </b-input-group-prepend>
      <b-form-input id="input-large" size="lg" placeholder="ID"></b-form-input>
      <!-- 이름 -->
      <b-input-group-prepend
        is-text
        style="font-family: 'KyoboHand'; text-decoration-line: none"
      >
        <b-icon icon="person-circle"></b-icon> &nbsp;이름
      </b-input-group-prepend>
      <b-form-input
        id="input-large"
        size="lg"
        placeholder="NAME"
      ></b-form-input>
      <!-- 패스워드 -->
      <b-input-group-prepend
        is-text
        style="font-family: 'KyoboHand'; text-decoration-line: none"
      >
        <b-icon icon="key-fill"></b-icon> &nbsp;패스워드
      </b-input-group-prepend>
      <b-form-input id="input-large" size="lg" placeholder="PW"></b-form-input>
      <!--이메일  -->
      <b-input-group-prepend
        is-text
        style="font-family: 'KyoboHand'; text-decoration-line: none"
      >
        <b-icon icon="envelope"></b-icon> &nbsp;이메일
      </b-input-group-prepend>
      <b-form-input
        id="input-large"
        size="lg"
        placeholder="E-MAIL"
      ></b-form-input>
    </b-col>
    <br />
    <b-button
      @click="confirm"
      class="btn-light"
      style="
        font-family: 'KyoboHand';
        font-size: 20pt;
        text-decoration-line: none;
        color: black;
      "
    >
      회원가입&nbsp;<img
        src="@/assets/img/greencrayon.png"
        style="width: 35px" /></b-button
    >&nbsp;
    <b-button
      :to="{ name: 'Home' }"
      class="btn-light"
      style="
        font-family: 'KyoboHand';
        font-size: 20pt;
        text-decoration-line: none;
        color: black;
      "
      >홈으로&nbsp;<img src="@/assets/img/yellowpen.png" style="width: 37px"
    /></b-button>
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
