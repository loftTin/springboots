<template>
  <div class="dashboard-container">
    <div class="dashboard-text">
      珍不珍稀博客管理系统
    </div>
    <div>
      · 欢迎关注我们的guihub仓库：<a href="https://github.com/loftTin/springboots/">https://github.com/loftTin/springboots/</a>
    </div>
    <div>
      · 自然是最有耐心，它用曲线规划山海，用山海孕育生命
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
