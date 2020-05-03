import Vue from "vue";

import "./styles/quasar.scss";
import "@quasar/extras/material-icons/material-icons.css";
import {
  Quasar,
  QLayout,
  QHeader,
  QDrawer,
  QPageContainer,
  QPage,
  QToolbar,
  QToolbarTitle,
  QBtn,
  QIcon,
  QList,
  QItem,
  QItemSection,
  QItemLabel,
  QTabs,
  QTab,
  QRouteTab,
  QPullToRefresh,
  QCard,
  QCardSection,
  QCardActions,
  QSeparator,
  QInput,
  QDialog,
  ClosePopup,
  QAvatar
} from "quasar";

Vue.use(Quasar, {
  config: {},
  components: {
    QLayout,
    QHeader,
    QDrawer,
    QPageContainer,
    QPage,
    QToolbar,
    QToolbarTitle,
    QBtn,
    QIcon,
    QList,
    QItem,
    QItemSection,
    QItemLabel,
    QTabs,
    QTab,
    QRouteTab,
    QPullToRefresh,
    QCard,
    QCardSection,
    QCardActions,
    QSeparator,
    QInput,
    QDialog,
    QAvatar
  },
  directives: {
    ClosePopup
  },
  plugins: {}
});
