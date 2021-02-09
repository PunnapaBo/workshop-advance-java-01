import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        Integer speakerId = null;
        validateRegisterData(speaker);

        int exp = speaker.getExp();
        speaker.setRegistrationFee(calculateFee( exp));
        try {
            speakerId = repository.saveSpeaker(speaker);
        }catch (Exception exception) {
            throw new SaveSpeakerException("Can't save a speaker.");
        }

       /* if (isFirstNameNotBlank(speaker.getFirstName())) {
            if (isLastNameNotBlank(speaker.getLastName())) {
                if (isEmailNotBlank(speaker.getEmail())) {
                    String emailDomain = getEmailDomain(speaker.getEmail()); // outofbound
                    if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() == 1) {
                        int exp = speaker.getExp();
                        speaker.setRegistrationFee(calculateFee( exp));
                        try {
                            speakerId = repository.saveSpeaker(speaker);
                        }catch (Exception exception) {
                            throw new SaveSpeakerException("Can't save a speaker.");
                        }
                    } else {
                        throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
                    }
                } else {
                    throw new ArgumentNullException("Email is required.");
                }
            }else {
                throw new ArgumentNullException("Last name is required.");
            }
        } else {
            throw new ArgumentNullException("First name is required.");
        }
*/
        return speakerId;
    }

    private void validateRegisterData(Speaker speaker) {
        if(isFirstNameBlank(speaker.getFirstName())){
            throw new ArgumentNullException("First name is required.");
        }
        if(isLastNameBlank(speaker.getLastName())){
            throw new ArgumentNullException("Last name is required.");
        }
        if(isEmailBlank(speaker.getEmail())){
            throw new ArgumentNullException("Email is required.");
        }
        String[] domains = {"gmail.com", "live.com"};
        String emailDomain = getEmailDomain(speaker.getEmail());
        if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() == 0) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }
    }
    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().equals("");
    }


    private boolean isEmailBlank(String email) {
        return isNullOrEmpty(email);
    }


    private boolean isLastNameBlank(String lastName) {
        return isNullOrEmpty(lastName);
    }

    private boolean isFirstNameBlank(String firstName) {
        return isNullOrEmpty(firstName);
    }

    public int calculateFee( int exp) {
        int fee = 0;
        if (exp <= 1) {
           fee = 500;
        } else if (exp <= 3) {
            fee = 250;
        } else if (exp >= 4 && exp <= 5) {
            fee = 100;
        } else if (exp >= 6 && exp <= 9) {
            fee = 50;
        }

        return fee;
    }

    public String getEmailDomain(String email) {
        String[] split = email.split("@");
        if(split.length != 2){
            throw new InvalidEmailFormatException("Email format isn't valid");
        }
        return split[1];
    }

}
