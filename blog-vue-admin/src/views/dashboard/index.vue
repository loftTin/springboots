<template>
  <div class="dashboard-container">
    <div class="dashboard-text">
      BJUT-个人博客管理系统
    </div>
    <div>
      全部烧掉：<a href="https://github.com/loftTin/springboots/">请进</a>   焚尸炉
    </div>
    <div>
      快来被烧掉;D
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  }
}
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
