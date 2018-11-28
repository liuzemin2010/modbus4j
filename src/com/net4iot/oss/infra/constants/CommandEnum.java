package com.net4iot.oss.infra.constants;

public enum CommandEnum {

    POWER("power", 84),
    MODE("mode", 81),
    FUN("fun", 83),
    SETTEMP("setTemp", 82),
    NOWTEMP("nowTemp", 264),
    WLOCK("wlock", 85);

    private String businessCode;

    private int registerAddress;

    CommandEnum(String businessCode, int registerAddress) {
        this.businessCode = businessCode;
        this.registerAddress = registerAddress;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public int getRegisterAddress() {
        return registerAddress;
    }

    public static int getValueByKey(String businessCode) {
        CommandEnum[] commandEnums = values();
        for (CommandEnum commandEnum : commandEnums) {
            if (commandEnum.getBusinessCode().equals(businessCode)) {
                return commandEnum.getRegisterAddress();
            }
        }
        return 0;
    }
}
