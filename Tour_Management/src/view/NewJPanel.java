/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

/**
 *
 * @author lemin
 */
public class NewJPanel extends javax.swing.JPanel {

	/**
	 * Creates new form NewJPanel
	 */
	public NewJPanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		pnInput = new javax.swing.JPanel();
		pnInsert = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		pnControl = new javax.swing.JPanel();
		btnCancel = new javax.swing.JButton();
		btnAdd = new javax.swing.JButton();
		btnPrint = new javax.swing.JButton();
		scrMain = new javax.swing.JScrollPane();
		tblMain = new javax.swing.JTable();

		pnInput.setLayout(new javax.swing.BoxLayout(pnInput, javax.swing.BoxLayout.Y_AXIS));

		jLabel1.setLabelFor(jTextField1);
		jLabel1.setText("jLabel1");
		jLabel1.setToolTipText("");
		jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

		jTextField1.setText("jTextField1");
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnInsertLayout = new javax.swing.GroupLayout(pnInsert);
		pnInsert.setLayout(pnInsertLayout);
		pnInsertLayout.setHorizontalGroup(pnInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnInsertLayout.createSequentialGroup().addContainerGap()
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
						.addContainerGap()));
		pnInsertLayout.setVerticalGroup(pnInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnInsertLayout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(pnInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		pnInput.add(pnInsert);

		btnCancel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnCancel.setText("HỦY");
		btnCancel.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCancelActionPerformed(evt);
			}
		});

		btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnAdd.setText("THÊM");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});

		btnPrint.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
		btnPrint.setText("IN");
		btnPrint.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPrintActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnControlLayout = new javax.swing.GroupLayout(pnControl);
		pnControl.setLayout(pnControlLayout);
		pnControlLayout
				.setHorizontalGroup(
						pnControlLayout
								.createParallelGroup(
										javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnControlLayout.createSequentialGroup().addGap(121, 121, 121)
										.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnControlLayout.setVerticalGroup(pnControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnControlLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(pnControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 25,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		tblMain.setModel(
				new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		scrMain.setViewportView(tblMain);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(pnInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(scrMain).addComponent(pnControl, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(pnInput, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnControl, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(scrMain, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField1ActionPerformed

	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnAddActionPerformed

	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnCancelActionPerformed

	private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrintActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnPrintActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAdd;
	private javax.swing.JButton btnCancel;
	private javax.swing.JButton btnPrint;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JPanel pnControl;
	private javax.swing.JPanel pnInput;
	private javax.swing.JPanel pnInsert;
	private javax.swing.JScrollPane scrMain;
	private javax.swing.JTable tblMain;
	// End of variables declaration//GEN-END:variables
}
