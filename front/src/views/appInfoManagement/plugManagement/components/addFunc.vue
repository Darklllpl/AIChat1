<template>
  <el-dialog :visible="addFuncDialogVisible" title="创建函数" @close="close">
    <el-form ref="addFunc" :model="funcInfo" :rules="rules" align="right">
      <!-- 表单内容 -->
      <el-form-item prop="name" label="函数名称">
        <el-input v-model="funcInfo.name" style="width: 75%" placeholder="请输入函数名称" />
      </el-form-item>
      <el-form-item prop="enName" label="函数名称（英）">
        <el-input v-model="funcInfo.enName" style="width: 75%" placeholder="请输入函数名称" />
      </el-form-item>
      <el-form-item prop="typeId" label="函数类型">
        <el-select v-model="funcInfo.typeId" style="width: 75%" placeholder="请选择函数类型">
          <el-option v-for="item in typeList" :key="item.id" :label="item.type" :value="item.id" />
        </el-select>
      </el-form-item>

      <el-form-item prop="apiId" label="服务API">
        <el-select v-model="funcInfo.apiId" style="width: 75%" placeholder="请选择服务API">
          <el-option v-for="item in apiList" :key="item.id" :label="item.api" :value="item.id" />
        </el-select>
      </el-form-item>

      <el-form-item prop="description" label="函数描述">
        <el-input
          v-model="funcInfo.description"
          type="textarea"
          rows="4"
          style="width: 75%"
          maxlength="255"
          show-word-limit
          placeholder="请输入函数描述"
        />
      </el-form-item>
      <el-form-item>
        <el-row>
          <el-col span="10">
            <el-button type="primary" @click="close">关闭</el-button>
            <el-button type="primary" @click="submitFuncInfo">确认</el-button>
          </el-col>
        </el-row>
      </el-form-item>
    </el-form>
  </el-dialog>
</template>
<script>
import { getTypeList, getApiList, addFunc } from '@/api/plug'
export default {
  props: {
    addFuncDialogVisible: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      // 样例数据，后续等数据库完善，使用api提供的
      typeList: [{ id: 1, type: '类型1' }, { id: 2, type: '类型2' }, { id: 3, type: '类型3' }],
      apiList: [{ id: 1, api: '服务API 1' }, { id: 2, api: '服务API 2' }, { id: 3, api: '服务API 3' }],
      funcInfo: {
        id: '',
        name: '',
        enName: '',
        typeId: '',
        apiId: '',
        description: ''
      },
      rules: {
        name: [{ required: true, message: '函数名称不能为空', trigger: 'blur' }],
        enName: [{ required: true, message: '函数英文名称不能为空', trigger: 'blur' }],
        typeId: [{ required: true, message: '函数类型不能为空', trigger: 'blur' }],
        apiId: [{ required: true, message: '服务API不能为空', trigger: 'blur' }],
        description: [{ required: true, message: '函数描述不能为空', trigger: 'blur' }]
      }
    }
  },
  created() {
    this.getTypeList()
    this.getApiList()
  },
  methods: {
    close() {
      this.$emit('update:addFuncDialogVisible', false)
    },
    async getTypeList() {
      this.typeList = await getTypeList()
    },
    async getApiList() {
      this.apiList = await getApiList()
    },

    submitFuncInfo() {
      // 在这里处理提交逻辑
      // 可以发送请求或执行其他操作
      console.log('提交表单:', this.funcInfo)
      this.$refs.addFunc.validate(async isOk => {
        if (isOk) {
          await addFunc({ ...this.funcInfo })
          this.$emit('updateFuncTable')
          this.$message.success('新增函数成功')
        }
      })
      // 提交完成后关闭对话框
      this.addFuncDialogVisible = false
    }
  }
}
</script>
