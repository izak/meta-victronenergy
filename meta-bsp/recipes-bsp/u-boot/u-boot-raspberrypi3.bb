require u-boot-rpi.inc
PROVIDES = ""

# We are only interested in the u-boot binary. Override all else and deploy
# only that.
do_install[noexec] = "1"
do_populate_sysroot[noexec] = "1"
do_package_qa[noexec] = "1"
do_package_write_deb[noexec] = "1"
do_perform_packagecopy[noexec] = "1"

UBOOT_MACHINE="rpi_3_32b_config"

do_deploy () {
   install ${S}/${UBOOT_BINARY} ${DEPLOYDIR}/u-boot-rpi3.bin
}
