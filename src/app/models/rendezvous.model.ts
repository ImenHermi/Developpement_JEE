export interface RendezVous {
    id?: number;
    date: string;
    statut: string;
    patient: {
        id: number;
};
    medecin: {
        id: number;
};
}
