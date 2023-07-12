<!-- 友情链接模块 -->
<template>
    <div class="tFriendsBox">
        <h1>友链申请格式</h1>
        <h3>网站名称：Clarkson's Farm</h3>
        <h3>网站地址: https://www.bilibili.com/video/BV1F54y1K76g/?spm_id_from=333.999.0.0 </h3>
        <h3>网站描述: 英国最著名但最不合格的业余农民杰里米·克拉克森回归了！“一毛之地”农场迎来了新一年...</h3>
        <h3>网站logo: http://rxauma9r3.hb-bkt.clouddn.com/link01.jpg</h3>
        <el-row>
            <el-col :span="12" class="tf-item" v-for="(item, index) in friendslink" :key="'f' + index">
                <a :href="item.address" target="_blank">
                    <img :src="item.logo ? item.logo : 'static/img/tou.jpg'" :onerror="$store.state.errorImg">
                    <h4>{{ item.name }}</h4>
                    <p>{{ item.description }}</p>
                </a>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import { getAllLink } from '../api/link.js'
export default {
    data() { //选项 / 数据
        return {
            friendslink: []//友情链接
        }
    },
    methods: { //事件处理器
        getList() {
            getAllLink().then((response) => {
                this.friendslink = response
            })
        }
    },
    components: { //定义组件

    },
    created() { //生命周期函数
        this.getList()
    }
}
</script>

<style>
.tFriendsBox {
    background: #fff;
    padding: 15px;
    border-radius: 5px;
    margin-bottom: 40px;
}

.tFriendsBox h1 {
    padding: 15px 0;
    font-size: 25px;
    font-weight: bold;
}

.tFriendsBox .tf-item {
    transition: all 0.3s ease-out;
    border-radius: 5px;
    position: relative;
}

.tFriendsBox .tf-item:hover {
    background: rgba(230, 244, 250, .5);
}

.tFriendsBox .tf-item a {
    display: block;
    padding: 0 10px 0 90px;
    height: 90px;
}

.tFriendsBox .tf-item a img {
    width: 60px;
    height: 60px;
    border-radius: 50%;
    position: absolute;
    top: 15px;
    left: 15px;
    cursor: pointer;
    object-fit: cover;
}

.tFriendsBox .tf-item a h4 {
    cursor: pointer;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
    font-size: 20px;
    padding-top: 15px;
    font-weight: bold;
}

.tFriendsBox .tf-item a p {
    margin: 10px 0;
    font-size: 12px;
    line-height: 24px;
    color: #999;
    cursor: pointer;
    white-space: nowrap;
    text-overflow: ellipsis;
}</style>
