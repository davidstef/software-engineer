package controller.account;

import factory.ComponentFactory;
import model.Account;
import repository.EntityNotFoundException;
import service.account.AccountService;
import view.account.TransferBeweenAccountsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferMoneyController {

    private TransferBeweenAccountsView transferBeweenAccountsView;
    private final ComponentFactory componentFactory;
    private final AccountService accountService;

    public TransferMoneyController (TransferBeweenAccountsView transferBeweenAccountsView) {
        this.transferBeweenAccountsView = transferBeweenAccountsView;
        transferBeweenAccountsView.setBtnTransfer(new TransferMoneyController.ButtonTransferBetweenAccountsListener());
        transferBeweenAccountsView.setBtnBack(new TransferMoneyController.ButtonBackTransferBetweenAccountListener());
        componentFactory = ComponentFactory.getInstance();
        accountService = componentFactory.getAccountService();
    }

    private class ButtonBackTransferBetweenAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            transferBeweenAccountsView.setVisible(false);
        }
    }

    private class ButtonTransferBetweenAccountsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Account payerAccount = accountService.findById(Long.valueOf(transferBeweenAccountsView.getTxtIdAccount1().getText()));
                Account recipientAccount = accountService.findById(Long.valueOf(transferBeweenAccountsView.getTxtIdAccount2().getText()));
                Double amount = Double.valueOf(transferBeweenAccountsView.getTxtAmountTransferred().getText());

                payerAccount.setAmountOfMoney(payerAccount.getAmountOfMoney() - amount);
                recipientAccount.setAmountOfMoney(recipientAccount.getAmountOfMoney() + amount);

                accountService.update(payerAccount, payerAccount.getId());
                accountService.update(recipientAccount, recipientAccount.getId());

            }
            catch (EntityNotFoundException entityNotFoundException) {
                JOptionPane.showMessageDialog(transferBeweenAccountsView.getContentPane(), "The amount could not be transferred!");
            }
        }
    }
}
