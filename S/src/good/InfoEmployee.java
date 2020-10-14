package good;

public class InfoEmployee {
    private GoodEmployee employee;

    public InfoEmployee(GoodEmployee emp) {
        this.employee = emp;
    }

    public int calculatePay() {
        switch (employee.getStatus()) {
            case "A":
                return 1;
            case "B":
                return 2;
            default:
                return 0;
        }
    }

    public void save() {
        System.out.printf("%s saved to database.\n", employee.getName());
    }

    public String reportHours() {
        return String.format("%s worked %d hours.\n", employee.getName(), employee.getHours());
    }
}
