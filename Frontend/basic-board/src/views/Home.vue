<template>
  <div class="home">
  <img src="@/assets/img/rainbow.png" alt="cloud"
  style="height:550px"
  >
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: "Home",
  components: {
  },
};
</script>

<style scoped>
  img{
    height: 100vh; /*각 화면에 맞는 꽉 찬 사이즈로 변경*/
  background-repeat: no-repeat;
  background-size: cover;
  }
</style>
