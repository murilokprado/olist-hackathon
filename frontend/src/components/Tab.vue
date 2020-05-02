<template>
  <div class="tab" :class="{ 'tab--active': active }">
    <div class="tab__icon">
      <q-icon :name="icon" size="sm" />
    </div>
    <div class="tab__name">
      {{ name }}
    </div>
  </div>
</template>

<script>
export default {
  name: "Tab",
  props: {
    icon: String,
    name: String,
    active: Boolean
  }
};
</script>

<style lang="scss" scoped>
.tab {
  align-items: center;
  background: #30444e;
  border-radius: 20px;
  box-shadow: 0px 1px 14px #19282f;
  cursor: pointer;
  display: flex;
  flex-direction: column;
  height: 122px;
  justify-content: center;
  width: 30%;
}

.tab--active {
  background: #28a2e4;

  .tab__icon {
    background: white;
    border-color: white;
    color: black;
  }

  .tab__name {
    color: white;
  }
}

.tab__icon {
  align-items: center;
  border-radius: 70px;
  border: 1px solid #475e69;
  display: flex;
  height: 70px;
  justify-content: center;
  width: 70px;
}

.tab__name {
  color: #96a7af;
  padding-top: 8px;
}
</style>
