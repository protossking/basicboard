<template>
  <footer class="footer">
    <div class="align-items-center px-3 py-2">
      <strong class="mr-auto">집 없는 중개업자</strong>
      <div>E-mail : happyhouse@happyhouse.com</div>
      <br />
      <div>
        ⓒCopyright 2021-2021 by 집 없는 중개업자. All Rights Reserved.
        HappyHouse is Powered by Vue.js
      </div>
    </div>
    <strong class="mr-auto">@안영원 @최윤희</strong>
    <br />
    <router-link to="/">
      <img
        src="@/assets/happyhouse_logo.png"
        class="d-inline-block align-middle"
        width="60px"
        alt="logo"
      />
    </router-link>
  </footer>
</template>

<script>
export default {};
</script>

<style scoped>
.footer {
  background-color: #ffffff;
  border-top: 2px solid rgb(189, 189, 189);
  color: gray;
}
</style>
