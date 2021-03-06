package ca.josephroque.partners.util;

import android.content.Intent;
import android.net.Uri;

/**
 * Created by Joseph Roque on 2015-07-06. Provides methods related to creating and formatting emails
 * which the user can select to create from the application. A local mail application on the device
 * will be used to handle writing and sending the email.
 */
public final class EmailUtils
{

    /** To identify output from this class in the Logcat. */
    @SuppressWarnings("unused")
    private static final String TAG = "EmailUtils";

    /**
     * Default private constructor.
     */
    private EmailUtils()
    {
        // does nothing
    }

    /**
     * Creates an email intent and sets values to parameters.
     *
     * @param recipientEmail email recipient
     * @param emailSubject subject of the email
     * @param emailBody body of the email
     * @return new email intent
     */
    public static Intent getEmailIntent(
            String recipientEmail,
            String emailSubject,
            String emailBody)
    {
        if (emailBody == null)
            emailBody = "";

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipientEmail});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

        return emailIntent;
    }
}
