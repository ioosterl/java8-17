public class SwitchExpressions {

    static enum WeekDays {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY;
    }

    public static void main(String[] args) {

        saySomethingForAWeekDayWithSwitchStatement(WeekDays.MONDAY);
        saySomethingForAWeekDayWithSwitchExpression(WeekDays.TUESDAY);
    }

    private static void saySomethingForAWeekDayWithSwitchExpression(WeekDays weekday) {
        String message = switch (weekday) {
            case MONDAY -> "Start of the week";
            case TUESDAY -> "Getting warmed up in the workweek";
            case WEDNESDAY -> "Half way through the week";
            case SATURDAY -> "Time to relax";
            case SUNDAY -> "Oh no, it's about to start all over again";
            default -> "I can smell the weekend from here";
        };

        System.out.println(message);

    }

    private static void saySomethingForAWeekDayWithSwitchStatement(WeekDays weekday) {
        String message = null;
        switch(weekday) {
            case MONDAY:
                message = "Start of the week";
                break;
            case TUESDAY:
                message = "Getting warmed up in the workweek";
                break;
            case WEDNESDAY:
                message = "Half way through the week";
                break;
            case SATURDAY:
                message = "Time to relax";
                break;
            case SUNDAY:
                message = "Oh no, it's about to start all over again";
                break;
        }
        System.out.println(message);
    }


}
