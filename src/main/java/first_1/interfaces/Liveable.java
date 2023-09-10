package first_1.interfaces;

import first_1.exception.WorkLifeBalanceException;

public interface Liveable {
    void sleep();

    void work();

    void eat();

    void hobby() throws WorkLifeBalanceException;

    void live();
}
