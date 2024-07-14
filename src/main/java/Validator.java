/**
 * StudentID: 6510450861
 * Name: Moradop Hengprasert
 */


import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {

    /**
     * Code นี้ขัดกับ Design Principles
     * - Single Responsibility Principle (SRP):
     *   คือฟังก์ชัน register ทำงานหลายอย่าง เช่น ตรวจสอบชื่อ อีเมล และอายุ ซึ่งควรแยกออกเป็นฟังก์ชันย่อยๆ
     *   ดังนี้
     */

    public boolean register(User user) {
        checkNameValid(user.getName());
        checkEmailValid(user.getEmail());
        checkAgeValid(user.getAge());
        return true;
    }

    private void checkNameValid(String name) {
        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name should not empty");
        }
        if (!name.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Name is wrong format");
        }
    }

    private void checkEmailValid(String email) {
        if (email == null || email.trim().equals("")) {
            throw new IllegalArgumentException("Email should not empty");
        }
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern validEmailPattern = Pattern.compile(EMAIL_PATTERN);
        if(!validEmailPattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Email is wrong format");
        }
        List<String> notAllowDomains = Arrays.asList("dom1.cc","dom2.cc", "dom3.cc");
        if(notAllowDomains.contains(email.split("@")[1])) {
            throw new IllegalArgumentException("Domain Email is not allow");
        }
    }

    private void checkAgeValid(int age) {
        if(age < 20) {
            throw new IllegalArgumentException("Age should more than 20 years");
        }
    }
}
