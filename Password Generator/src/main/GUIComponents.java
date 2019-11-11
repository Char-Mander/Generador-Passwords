package main;

public enum GUIComponents {
        VENTANA_INICIO("VentanaInicio.fxml"),
        VENTANA_PASSWORD("EndWindow.fxml"),
        GENERATE_PASSWORD_BUTTON("#generatePass"),
        GO_TO_START_WINDOW_BUTTON("#loadVentanainicio"),
        DIRECTORY_TEXT_FIELD("#directory"),
        FILE_NAME_TEXT_FIELD("#fileName"),
        PASSWORD_NAME_TEXT_FIELD("#passwordName"),
        PASSWORD_LABEL("#password");

        private String id;

        GUIComponents(String _id) { this.id = _id; }

        public String getValue() { return this.id; }



}
