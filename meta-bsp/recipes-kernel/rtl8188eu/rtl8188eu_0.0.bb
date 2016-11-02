SUMMARY = "Add the rtl8188eu driver from Larry Finger as an out-of-tree module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.GPLv2;md5=751419260aa954499f7abaabaa882bbe"

# When building on openembedded Jethro, or older versions, make sure to apply
# this commit:
# https://github.com/openembedded/openembedded-core/commit/afcea61e8eb39234d336c706fdfd4680dea7c060
# to prevent warnings exactly like mentioned in that commit message.

inherit module

SRC_URI = " \
	gitsm://github.com/lwfinger/rtl8188eu.git;protocol=https;rev=ced2b64a1139dcaf86947e3a9f7617dffbd64239 \
	file://0001-fix-makefile-for-openembedded.patch \
    file://8188eu.conf \
"

S = "${WORKDIR}/git"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

do_install() {
    # Module
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/net/wireless
    install -m 0644 8188eu.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/net/wireless/8188eu.ko

	install -d ${D}${sysconfdir}/modprobe.d
	install -m 0644 ${WORKDIR}/8188eu.conf ${D}${sysconfdir}/modprobe.d/8188eu.conf
}
