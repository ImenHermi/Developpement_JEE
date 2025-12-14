import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialiteDetails } from './specialite-details';

describe('SpecialiteDetails', () => {
  let component: SpecialiteDetails;
  let fixture: ComponentFixture<SpecialiteDetails>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SpecialiteDetails]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpecialiteDetails);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
