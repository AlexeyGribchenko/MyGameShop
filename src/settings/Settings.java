package settings;

public class Settings {
    public static class Color {
        public static final String BLUE = "#2A475E";
        public static final String DARK_BLUE = "#1B2838";
        public static final String TEXT_CODE = "#b4c5d3";
        public static final String GREEN = "#BEEE11";
        public static final String DARK_GREEN = "#4c6b22";

    }
    public static class Window {
        public static final int MIN_WIDTH = 1280;
        public static final int MIN_HEIGHT = 720;
    }

    public static class Field {
        public static final int ELEMENT_HEIGHT = 30;
        public static final int ELEMENT_WIDTH = 120;
    }

    public static class Gap {
        public static final int MAX_GAP = 50;
        public static final int MIN_GAP = 10;
    }

    public static class GameCard {
        public static final int IMAGE_WIDTH = 260;
        public static final int IMAGE_HEIGHT = 130;
        public static final int CARD_HEIGHT = 100;
        public static final int CARD_WIDTH = 900;
        public static final int BTN_ICON_WIDTH = 25;
        public static final int BTN_ICON_HEIGHT = 25;
        public static final int BTN_WIDTH = 50;
        public static final int BTN_HEIGHT = 35;

        public static final int NAME_WIDTH = 100;
        public static final int DESCRIPTION_WIDTH = 200;
        public static final int PRICE_WIDTH = 50;
    }
    public static class ShopField {
        public static final int SEARCH_FILED_HEIGHT = 30;
        public static final int SEARCH_FILED_WIDTH = Short.MAX_VALUE;
        public static final int MIN_FILED_HEIGHT = 30;
        public static final int MAX_FILED_WIDTH = Short.MAX_VALUE;
    }
    public static class Header {
        public static final int WIDTH = Short.MAX_VALUE;
        public static final int HEIGHT = 55;
    }
}
