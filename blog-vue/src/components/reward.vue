<!-- 赞赏模块 -->
<template>
  <div class="tRewardBox tcommonBox">
    <header>
      <h1>
        <a href="#/DetailShare" target="_blank"> 鸣谢 </a>
      </h1>
    </header>
    <section>
      <div>
        <img src="static/img/coffee.jpg" alt="" style="max-width: 20%" class="coffee" />
      </div>
      <h1>特别鸣谢：</h1>
      <p>

        ---<br>

        我们要衷心感谢以下人士和组织，没有他们的支持和帮助，我们的个人博客网站将无法顺利搭建和运行。<br>

        首先，感谢肖老师、感谢《JAVA系统分析与架构设计》，在我们搭建个人博客的过程中提供的技术指导和宝贵建议。<br>

        感谢开源社区。感谢所有开源项目的贡献者，为我们个人博客网站的搭建提供了便捷的版本控制，你们的无私奉献使得我能够使用高质量的工具和技术来构建我们的个人博客网站。你们的工作为我提供了强大的功能和灵活的扩展性。<br>

        感谢互联网上无数博客作者和技术专家。你们的分享和教程对我们在个人博客搭建过程中的学习起到了重要作用。无论是技术问题的解答还是实用建议，你们的经验和知识都给予了我们巨大的帮助。<br>

        再次向以上所有人表示最衷心的感谢！<br>

        ---<br>
      </p>
      <hr />
      <h1>赞赏方式：</h1>
      <el-row :gutter="30">
        <el-col :span="12" class="donate-item">
          <div class="donate-tip">
            <img :src="rewardData.wechat_image
                ? rewardData.wechat_image
                : 'static/img/wx_pay.png'
              " :onerror="$store.state.errorImg" />
            <span>微信扫一扫，请我喝杯咖啡</span>
          </div>
        </el-col>
        <el-col :span="12" class="donate-item">
          <div class="donate-tip">
            <img :src="rewardData.alipay_image
                ? rewardData.alipay_image
                : 'static/img/ali_pay.jpg'
              " :onerror="$store.state.errorImg" />
            <span style="padding-top: 14px">支付宝扫一扫，请我喝杯咖啡</span>
          </div>
        </el-col>
      </el-row>
      <h1>@赞赏记录：</h1>
      <el-table :data="tableData" border style="width: 100%">
        <el-table-column prop="payTime" label="日期" align="center"></el-table-column>
        <el-table-column prop="name" label="" align="center"></el-table-column>
        <el-table-column prop="money" label="金额" align="center"></el-table-column>
      </el-table>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    //选项 / 数据
    return {
      rewardData: "", //赞赏二维码
      tableData: [
        {
          //赞赏数据
          "payTime": "2077-07-07",
          "name": "anon",
          "money": "188"
        },
        {
          "payTime": "2012-2-31",
          "name": "happycat",
          "money": "50"
        },
        {
          "payTime": "2023-13-12",
          "name": "BJUTer",
          "money": "30"
        },
      ],
    };
  },
  methods: {
    //事件处理器
    showInitDate: function (date, full) {
      //时间处理
      return initDate(date, full);
    },
  },
  components: {
    //定义组件
  },
  created() {
    //生命周期函数
    var that = this;
  },
};
</script>

<style>
.tRewardBox section {
  padding-bottom: 20px;
}

.tRewardBox section h1 {
  margin: 10px 0;
  font-size: 25px;
  font-weight: 700;
  /*text-align: center;*/
  line-height: 30px;
}

.tRewardBox section p {
  margin: 10px 0;
  line-height: 24px;
}

.tRewardBox section hr {
  background: #ccc;
  margin-bottom: 30px;
}

.tRewardBox .donate-item {
  text-align: right;
  color: #44b549;
}

.tRewardBox .donate-item:last-child {
  text-align: left;
  color: #00a0e9;
}

.tRewardBox .donate-item img {
  width: 100%;
  display: block;
  height: auto;
}

.tRewardBox .donate-item div {
  display: inline-block;
  width: 150px;
  padding: 0 6px;
  text-align: center;
  box-sizing: border-box;
}

.tRewardBox .donate-item div span {
  display: inline-block;
  width: 100%;
  margin: 10px 0;
  text-align: center;
}

.tRewardBox .el-table__body-wrapper {
  overflow: hidden;
}

.el-table--enable-row-hover .el-table__body tr:hover>td {
  background: transparent;
}
</style>
