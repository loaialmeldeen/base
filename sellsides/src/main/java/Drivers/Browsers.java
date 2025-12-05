package Drivers;

public enum Browsers {
    CHROME {
        @Override
        public AbstractDriver getDriverfactory() {
            return new ChromeFactory();
        }
    },
    EDGE {
        @Override
        public AbstractDriver getDriverfactory() {
            return new EdgeFactory();
        }
    },
    FIREFOX {
        @Override
        public AbstractDriver getDriverfactory() {
            return new FirefoxFactory();
        }
    };

    public abstract AbstractDriver getDriverfactory();

}
