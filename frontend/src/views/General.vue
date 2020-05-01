<template>
  <div class="general">
    <h5>Métricas do dia</h5>
    <div class="row">
      <img :src="img" class="col-xs-12 col-sm-6 col-md-4 col-lg-3" />
      <img :src="img" class="col-xs-12 col-sm-6 col-md-4 col-lg-3" />
      <img :src="img" class="col-xs-12 col-sm-6 col-md-4 col-lg-3" />
      <img :src="img" class="col-xs-12 col-sm-6 col-md-4 col-lg-3" />
    </div>
  </div>
</template>

<script>
export default {
  name: "General",
  data() {
    return {
      img:
        "https://h5p.org/sites/default/files/styles/medium-logo/public/logos/chart-icon-color.png?itok=kpLTYHHJ"
    };
  }
};
</script>

<style lang="scss" scoped>
.general {
  display: flex;
  flex-direction: column;
  padding: 32px;
}

h5 {
  text-align: left;
  margin: 0;
}
</style>
