package com.sudhu;

import com.azure.identity.DefaultAzureCredentialBuilder;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String keyVaultName = "testkeyvaultsudhu";
        String keyVaultUri = "https://" + keyVaultName + ".vault.azure.net/";

        System.out.printf("key vault name = %s and key vault URI = %s \n", keyVaultName, keyVaultUri);

        SecretClient secretClient = new SecretClientBuilder().vaultUrl(keyVaultUri)
                .credential(new DefaultAzureCredentialBuilder().build()).buildClient();

        // Console con = System.console();

        String secretName = "tempkey";

        // System.out.println("Please provide the value of your secret > ");

        // String secretValue = con.readLine();

        // System.out.print("Creating a secret in " + keyVaultName + " called '" +
        // secretName + "' with value '"
        // + secretValue + "` ... ");

        // secretClient.setSecret(new KeyVaultSecret(secretName, secretValue));

        // System.out.println("done.");
        // System.out.println("Forgetting your secret.");

        // secretValue = "";
        // System.out.println("Your secret's value is '" + secretValue + "'.");

        System.out.println("Retrieving your secret from " + keyVaultName + ".");

        KeyVaultSecret retrievedSecret = secretClient.getSecret(secretName);

        System.out.println("Your secret's value is '" + retrievedSecret.getValue() + "'.");
        // System.out.print("Deleting your secret from " + keyVaultName + " ... ");

        // SyncPoller<DeletedSecret, Void> deletionPoller =
        // secretClient.beginDeleteSecret(secretName);
        // deletionPoller.waitForCompletion();

        System.out.println("done.");
    }
}
