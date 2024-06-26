import org.jetbrains.annotations.NotNull;

public class JavaMoney implements Comparable<JavaMoney>{
    private final long amount;

    public JavaMoney(long amount){
        this.amount = amount;
    }

    @Override
    public int compareTo(@NotNull JavaMoney o) {
        return Long.compare(this.amount, o.amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JavaMoney javaMoney =(JavaMoney) obj;
        return amount == javaMoney.amount;
    }
}
