<template>
  <div class="coins">
    <div class="coins__card">
      <Progress-Card icon="monetization_on" title="Nível 1" />
    </div>
    <div class="coins__level">
      <Level-Icon
        class="coins__level-item"
        icon="monetization_on"
        title="Nível 1"
        active
      />
      <Level-Icon
        class="coins__level-item"
        icon="directions_bike"
        title="Nível 2"
      />
      <Level-Icon
        class="coins__level-item"
        icon="directions_car"
        title="Nível 3"
      />
      <Level-Icon
        class="coins__level-item"
        icon="flight_takeoff"
        title="Nível 4"
      />
    </div>
    <h5>Recompensas</h5>
    <h6>Complete os objetivos e troque por prêmios</h6>
    <section class="rewards row">
      <div class="col-12">
        <div class="row">
          <div class="reward col-xs-3 col-sm-3 col-md-1 col-lg-6">
            <img src="@/assets/emoji-cadastro.png" alt="Sr. Cadastro" />
            <div class="reward__title">Sr. cadastro</div>
          </div>
          <div class="reward col-xs-3 col-sm-3 col-md-1 col-lg-6">
            <img src="@/assets/emoji_tempo_eh_tudo.png" alt="Tempo é tudo" />
            <div class="reward__title">Tempo é tudo</div>
          </div>
          <div class="reward col-xs-3 col-sm-3 col-md-1 col-lg-6">
            <img src="@/assets/emoji-pediu-chegou.png" alt="Pediu, chegou" />
            <div class="reward__title">Pediu, chegou</div>
          </div>
        </div>
      </div>
    </section>
    <Progress style="margin-top: 16px" />
  </div>
</template>

<script>
import ProgressCard from "@/components/ProgressCard";
import LevelIcon from "@/components/LevelIcon";
import Progress from "@/components/Progress";

export default {
  name: "Coins",
  components: {
    ProgressCard,
    LevelIcon,
    Progress
  }
};
</script>

<style lang="scss" scoped>
h3 {
  margin: 0;
}

.coins {
  padding: 24px;
}

.coins__card {
  background: #30444e;
  box-shadow: 0px 1px 14px #19282f;
  border-radius: 25px;
  padding: 24px;
}

.coins__level {
  display: flex;
  padding: 16px 0;
}

.coins__level-item {
  margin: 8px;
}

.rewards {
  display: flex;
  background: #2a3c44;
  padding: 12px;
  justify-content: flex-start;
  flex-wrap: wrap;
  border-radius: 40px 0px 0px 0px;
}

.reward {
  margin-left: 8px;
}

.reward img {
  width: 70px;
}

.reward__title {
  font-weight: bold;
  font-size: 11px;
}
</style>
