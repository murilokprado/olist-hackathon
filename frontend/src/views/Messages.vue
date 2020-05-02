<template>
  <div class="messages">
    <h5>Aguardando respostas</h5>
    <div class="row">
      <div
        v-for="i in [1, 2, 3, 4]"
        :key="i"
        class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
      >
        <div class="custom-card">
          <WaitingReturn :question="`question ${i}`" />
        </div>
      </div>
    </div>
    <h5>Respostas automáticas</h5>
    <div class="row">
      <div
        v-for="i in [1, 2, 3, 4, 5, 6, 7]"
        :key="i"
        class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
      >
        <div class="custom-card">
          <WaitingReturn :question="`question ${i}`" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import WaitingReturn from "@/components/WaitingReturnCard";

export default {
  name: "Messages",
  components: {
    WaitingReturn
  }
};
</script>

<style lang="scss" scoped>
.messages {
  padding: 32px;
}

.custom-card {
  color: #333;
  margin-right: 16px;
  margin-bottom: 16px;
}

h5 {
  text-align: left;
  margin: 0;
  margin-bottom: 16px;
}
</style>
