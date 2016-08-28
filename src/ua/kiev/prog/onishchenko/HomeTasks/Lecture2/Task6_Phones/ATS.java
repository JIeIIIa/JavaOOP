package ua.kiev.prog.onishchenko.HomeTasks.Lecture2.Task6_Phones;

public class ATS {
    private SimplePhone phones[];
    private int cntPhone;

    public ATS(){
        phones = new SimplePhone[100];
        cntPhone = 0;
    }

    public boolean addPhone(SimplePhone p) {
        if(cntPhone == phones.length) {
            SimplePhone[] tmp = new SimplePhone[phones.length * 2];
            System.arraycopy(phones, 0, tmp, 0, cntPhone);
            phones = tmp;
        }
        if (find(p.getNumber()) == null) {
            phones[cntPhone++] = p;
            return true;
        }
        return false;

    }

    public SimplePhone get(int index) {
        if (index > cntPhone) {
            return phones[cntPhone];
        } else if (index < 0) {
            return phones[0];
        } else
            return phones[index];

    }

    public boolean delete(int index) {
        if (index < 0 || index > cntPhone) {
            return false;
        } else {
            System.arraycopy(phones, index + 1, phones, index, phones.length - index - 1);
            return true;
        }
    }

    private SimplePhone find(String number) {
        for (int i = 0; i < cntPhone; i++) {
            if (phones[i].getNumber().equals(number)) {
                return phones[i];
            }
        }
        return null;
    }

    public void call(String number) {
        SimplePhone simplePhone = find(number);
        if (simplePhone == null) {
            System.out.println("Unknown number #" + number);
        } else {
            if (!simplePhone.isRegistered()) {
                System.out.println("The subscriber #" + number +
                        "  is not available.");
            } else {
                simplePhone.answer();
            }
        }
        System.out.println();
    }

    public void registerPhone(String number) {
        SimplePhone SimplePhone = find(number);
        if (SimplePhone != null) {
            SimplePhone.register();
        }
    }

    public void unRegisterPhone(String number) {
        SimplePhone SimplePhone = find(number);
        if (SimplePhone != null) {
            SimplePhone.unRegister();
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("ATS{ ");
        if (cntPhone == 0) {
            out.append("\n     EMPTY");
        } else {
            for (int i = 0; i < cntPhone; i++) {
                out.append("\n     ");
                out.append(phones[i]);
            }
        }
        out.append("\n   }\n");
        return out.toString();
    }
}


